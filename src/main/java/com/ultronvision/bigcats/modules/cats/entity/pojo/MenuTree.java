package com.ultronvision.bigcats.modules.cats.entity.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author oldwei
 * @date 2021-7-29 16:11
 */
@Data
public class MenuTree<T> implements Serializable {
    private static final long serialVersionUID = 2002074132172630365L;
    private String id;
    private String icon;
    private String title;
    private List<MenuTree<T>> children;
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private T data;
}
