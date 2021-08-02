package com.ultronvision.bigcats.modules.hik.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.hik.Category;
import com.ultronvision.bigcats.modules.hik.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author oldwei
 * @date 2021-8-2 11:11
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController extends BaseController {
    private final ICategoryService categoryService;

    /**
     * 分页列表
     * @return json
     */
    @GetMapping
    public ResponseEntity<JSONObject> category(@RequestBody Category category) {
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StrUtil.isNotBlank(category.getTitle()), Category::getTitle, category.getTitle());
        List<Category> list = this.categoryService.list(lambdaQueryWrapper);
        JSONObject result = new JSONObject();
        result.set("result", list);
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
        result.set("result", save);
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
        result.set("result", updateById);
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
        result.set("result", removeByIds);
        return ResponseEntity.ok(result);
    }
}
