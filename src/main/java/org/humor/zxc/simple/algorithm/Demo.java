package org.humor.zxc.simple.algorithm;

/**
 * Date: 2021/9/22
 * Time: 3:43 下午
 *
 * @author xuzz
 */
public class Demo {

    /**
     * 二叉树序列化
     */
    private static class TwoNodeTree {
        private Integer val;

        private TwoNodeTree left;

        private TwoNodeTree right;

        public String serialize(TwoNodeTree tree, String serial) {
            if (tree == null) {
                return "null";
            }
            serial += tree.val + ",";

            if (tree.left != null) {
                serialize(tree.left, serial);
            }
            if (tree.right != null) {
                serialize(tree.right, serial);
            }

            return serial;
        }

    }

    /**
     * ip归属地查找
     */
    private static class IpDemo {

        public String getCity(String ip) {
            String[] ipSplit = ip.split("\\.");

            return "";
        }


    }


}
