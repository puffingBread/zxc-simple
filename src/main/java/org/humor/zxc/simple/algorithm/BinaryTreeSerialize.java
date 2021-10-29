package org.humor.zxc.simple.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树序列化与反序列化
 * Date: 2021/9/26
 * Time: 5:49 下午
 *
 * @author xuzz
 */
public class BinaryTreeSerialize {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static String serialize(TreeNode root) {
        StringBuilder result = serializeHelp(new StringBuilder(), root);

//        StringBuilder r = new StringBuilder("[");
//        r.append(root.val);
//        while (root != null) {
//            if (root.val == null) {
//                r.append(",null");
//            } else {
//                r.append(root.left.val);
//                root = root.left;
//            }
//
//
//        }
//
//        while (root != null) {
//            if (root == null) {
//                r.append(",null");
//            } else {
//                r.append(root.val);
//                root = root.right;
//            }
//        }
        return result.toString();
    }

    public static StringBuilder serializeHelp(StringBuilder serial, TreeNode node) {
        if (node == null) {
            serial.append("null,");
            return serial;
        }
        serial.append(node.val).append(",");
        serial = serializeHelp(serial, node.left);
        serial = serializeHelp(serial, node.right);
        return serial;
    }

    public static TreeNode deserialize(String data) {
        String[] p = data.split(",");
        List<String> subList = new LinkedList<>(Arrays.asList(p));
        return deserializeHelp(subList);
    }

    public static TreeNode deserializeHelp(List<String> pList) {
        if (pList.size() == 0 || "null".equals(pList.get(0))) {
            pList.remove(0);
            return null;
        }

        TreeNode t = new TreeNode(Integer.parseInt(pList.get(0)));
        pList.remove(0);

        t.left = deserializeHelp(pList);
        t.right = deserializeHelp(pList);

        return t;
    }

    public static void main(String[] args) {
        String s = "1,2,3,null,null,4,5";
        TreeNode node = deserialize(s);
        System.out.println(serialize(node));
    }
}
