package com.ultronvision.bigcats.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author oldwei
 * @date 2021-7-29 16:11
 */
@Data
public class MenuTree<T> implements Serializable {
    private static final long serialVersionUID = 2002074132172630365L;
    private String id;
    private String icon;
//    private String href;
    private String title;
//    private Map<String, Object> state;
//    private boolean checked = false;
//    private Map<String, Object> attributes;
    private List<MenuTree<T>> children;
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private T data;

    public void initChildren(){
        this.children = new ArrayList<>();
    }
}
