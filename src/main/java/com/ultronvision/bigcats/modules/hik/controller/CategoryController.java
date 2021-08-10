package com.ultronvision.bigcats.modules.hik.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.hik.Category;
import com.ultronvision.bigcats.common.entity.hik.Device;
import com.ultronvision.bigcats.common.util.BigCatsUtil;
import com.ultronvision.bigcats.modules.hik.service.ICategoryService;
import com.ultronvision.bigcats.modules.hik.service.IDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author oldwei
 * @date 2021-8-2 11:11
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("hik/category")
public class CategoryController extends BaseController {
    private final ICategoryService categoryService;
    private final IDeviceService deviceService;

    /**
     * 分页列表
     * @return json
     */
    @GetMapping
    public ResponseEntity<JSONObject> category(Category category) {
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StrUtil.isNotBlank(category.getTitle()), Category::getTitle, category.getTitle());
        IPage<Category> page = new Page<>(category.getPageNo(), category.getPageSize());
        Map<String, Object> dataTable = BigCatsUtil.getDataTable(this.categoryService.page(page, lambdaQueryWrapper));
        JSONObject result = new JSONObject();
        result.put("result", dataTable);
        return ResponseEntity.ok(result);
    }

    /**
     * 列表
     * @return json
     */
    @GetMapping("list")
    public ResponseEntity<JSONObject> categoryList(Category category) {
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StrUtil.isNotBlank(category.getTitle()), Category::getTitle, category.getTitle());
        List<Category> list = this.categoryService.list(lambdaQueryWrapper);
        JSONObject result = new JSONObject();
        result.put("result", list);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据设备IP获取分组
     * @return json
     */
    @GetMapping("getCategoryByIp")
    public ResponseEntity<JSONObject> getCategoryByIp(String ip) {
        LambdaQueryWrapper<Device> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Device::getIp, ip);
        Device device = this.deviceService.getOne(lambdaQueryWrapper);
        Category category = this.categoryService.getById(device.getCategoryId());
        JSONObject result = new JSONObject();
        result.put("result", category);
        return ResponseEntity.ok(result);
    }

    /**
     * 添加
     * @return json
     */
    @PostMapping
    public ResponseEntity<JSONObject> addCategory(@RequestBody Category category) {
        boolean save = this.categoryService.save(category);
        JSONObject result = new JSONObject();
        result.put("result", save);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改
     * @return json
     */
    @PutMapping
    public ResponseEntity<JSONObject> modifyCategory(@RequestBody Category category) {
        boolean updateById = this.categoryService.updateById(category);
        JSONObject result = new JSONObject();
        result.put("result", updateById);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除
     * @return json
     */
    @DeleteMapping("/{categoryIds}")
    public ResponseEntity<JSONObject> deleteCategory(@PathVariable String categoryIds) {
        // 构造条件
        String[] ids = categoryIds.split(StringPool.COMMA);
        List<String> list = Arrays.asList(ids);
        boolean removeByIds = this.categoryService.removeByIds(list);
        JSONObject result = new JSONObject();
        result.put("result", removeByIds);
        return ResponseEntity.ok(result);
    }
}
