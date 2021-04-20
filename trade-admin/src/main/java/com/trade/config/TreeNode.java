package com.trade.config;


import lombok.Getter;
import lombok.Setter;

/**
 * Definition for a binary tree node.
 * @author Ben.Huang
 */
@Getter
@Setter
public class TreeNode implements Cloneable{
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      @Override
      public TreeNode clone(){
          TreeNode treeNode = null;
          try{
              treeNode = (TreeNode) super.clone();
          } catch (CloneNotSupportedException e) {
              e.printStackTrace();
          }
          return treeNode;
      }


  }

