package com.pigteam.airconditioning.common.utils.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: TreeNode
 * @author: zhujie
 * @version:
 * @date: 2019/4/25 16:37
 * @descripton:
 **/
@Data
@NoArgsConstructor
public class TreeNode<T> {

    public TreeNode(T model) {
        this.model = model;
    }

    private Long id;

    private Long parentId;

    private T model;

    private boolean hasChildren;

    private List<TreeNode<T>> children;

    public TreeNode(Long id, Long parentId, T model) {
        this.id = id;
        this.parentId = parentId;
        this.model = model;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
        if (children == null || children.isEmpty()) {
            this.hasChildren = false;
        } else {
            this.hasChildren = true;
        }
    }

}
