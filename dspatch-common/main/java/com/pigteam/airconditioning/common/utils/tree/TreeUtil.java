package com.pigteam.airconditioning.common.utils.tree;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @className: TreeUtil
 * @author: zhujie
 * @version:
 * @date: 2019/4/25 16:41
 * @descripton:
 **/
public class TreeUtil{

    public static TreeNode buildTree(List<TreeNode> treeNodes){
        TreeNode root = new TreeNode();
        root.setId(0L);
        root.setParentId(null);
       Map<Long,List<TreeNode>> groupBy = treeNodes.stream().collect(Collectors.groupingBy(TreeNode ::getParentId));
        root.setChildren(groupBy.get(0L));
        treeNodes.forEach(treeNode -> {
            treeNode.setChildren(groupBy.get(treeNode.getId()));
        });
        return root;
    }
}
