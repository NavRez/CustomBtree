# CustomBtree
A mini-project developped in 2018 to better understand the functionality and ordering of a B-Tree of order 3, also known as a Two-Three Tree. The project has two primary Java files : Dread_Node.java which serves as the nodes of the B-tree and BTree.java which adds is used to add nodes to the tree. The tree takes in integer values with each node being able to support a maximum of two values. For more information, consult the following page : https://en.wikipedia.org/wiki/2%E2%80%933_tree

## Insertion Process
If the root does not exist, the newly-inserted value becomes the root node. If the root already has two values and is a 2node, it will temporarily became a 3node before splitting into three seperate nodes with the left child having the smallest value and the right child having the biggest as well as the parent holding the mid value. If a tree is already established and an integer N is added, the insertion process is recursive and travels the child that closely matches with N.

## Splitting
The splitting process is also recursive and begins in the child nodes. The code was carefully crafted to make sure no 3nodes permanently exist and no nodes go unsplit. When a child node splits, it forwards its parent value to the parent and the process repeats as long as 3nodes are created.

## Printing
As there are various children in the tree, there are three ways to print out all the values in the B-Tree : preorder, postorder and inorder. All three of these were implemented in order to make sure the code was functioning correctly.

# How to use
Make sure that all three java files are in the same source path and run the code. The code will continuously ask for new inputs and give a the three different printout orders. 
