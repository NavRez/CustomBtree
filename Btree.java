public class Btree
	{

		public static Dread_Node root;/**
	holds the first node of the tree, the root
	*/


		public Btree()
		{
			/** sets the node to empty*/
			root = null;
		}

		public Dread_Node returnRoot()
        {
			return root;
        }

		public void insert(Dread_Node node, int num)
		{//inserts a number into a node

			if (isEmpty())
			{//check to see if the node is empty

				root = new Dread_Node(null, null, null, null, null, num);//enter the number into the node if so

			}
			else if (node.getRefer() < node.arr.length && node.nochildren())
			{//if the node is not a four node and has no children, insert the number into the node

				insertnum(node, num);

			}
			else
			{//if the node has children, do one of the following

				if (node.arr[0] >= num)
				{//if the number is smaller than the first value, recursively insert to the getLeft() node of the current node

					insert(node.getLeft(), num);

				}
				else if (node.arr[0] <= num && node.arr[1] == -1)
				{//if the number is greater than the first value and there is no getRight() value, recursively insert to the getRight() node of the current node

					insert(node.getRight(), num);

				}
				else if (node.arr[1] >= num && node.arr[0] < num && node.arr[2] == -1)
				{//if the number is greater than the first value and smaller than the second non-zero value, recursively insert to the middle node of the current node


					insert(node.getLeft_mid(), num);
				}
				else
				{//else insert to the getRight() node of the current node

					insert(node.getRight(), num);
				}

			}






		}


		public static boolean isEmpty()
		{//check to see if tree is empty, return true root is empty

			if (root == null)
			{

				return true;
			}

			return false;
		}


		public static void insertnum(Dread_Node somenode, int somval)
		{//inserts a number to the array of a given node

			if (somenode.arr[0] == -1)
			{//if there are no numbers, insert number in the first location

				somenode.arr[somenode.getRefer() + 1] = somval;
				somenode.setRefer(somenode.getRefer() + 1);
			}
			else if (somval <= somenode.arr[0] && somenode.arr[1] == -1)
			{//if there is only one num and it is greater than the value we wish to enter, move the current number to the getRight() and insert the new num to the getLeft()

				somenode.arr[1] = somenode.arr[0];
				somenode.arr[0] = somval;
				somenode.setRefer(somenode.getRefer() + 1);
			}
			else if (somval >= somenode.arr[0] && somenode.arr[1] == -1)
			{//if there is already one number but the number we wish to insert is greater or equal, insert it to the getRight()

				somenode.arr[1] = somval;
				somenode.setRefer(somenode.getRefer() + 1);
			}
			else if (somval <= somenode.arr[0] && somval < somenode.arr[1])
			{//if the number is smaller than the first or second, movethe first two to the getLeft() and insert num to the leftmost side

				somenode.arr[2] = somenode.arr[1];
				somenode.arr[1] = somenode.arr[0];
				somenode.arr[0] = somval;
				somenode.setRefer(somenode.getRefer() + 1);


			}
			else if (somval > somenode.arr[0] && somval >= somenode.arr[1])
			{//if it is greater than the two numbers, insert it to the rightmost side

				somenode.arr[2] = somval;
				somenode.setRefer(somenode.getRefer() + 1);

			}
			else
			{//else move arr[1] to the third spot and insert num at arr[1]

				somenode.arr[2] = somenode.arr[1];
				somenode.arr[1] = somval;
				somenode.setRefer(somenode.getRefer() + 1);

			}


			if (somenode.getRefer() == somenode.arr.length)
			{//if the node has become a fournode due to insertion, seperate them

				separate(somenode);
			}

		}


		public static void separate(Dread_Node node_to_split)
		{

			/**
			 *create three variables to holde the getLeft(), getRight() and middle values for the new node formations
			 */
			int mid = node_to_split.arr[1];
			int l = node_to_split.arr[0];
			int r = node_to_split.arr[2];



			if (node_to_split.getParent() == null)
			{//if the node is the root and insert the mid number (if it's the case) to the parent node


				Dread_Node lefttist = new Dread_Node(node_to_split.getLeft(), node_to_split.getLeft_mid(), null, null, null, l);//take the leftmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called lefttist
				if (node_to_split.getLeft() != null)
				{/** make the parent of the leftmost nodes, the lefttist node*/
					node_to_split.getLeft().setParent(lefttist);
				}
				if (node_to_split.getLeft_mid() != null)
				{
					node_to_split.getLeft_mid().setParent(lefttist);
				}

				Dread_Node righttist = new Dread_Node(node_to_split.getRight_mid(), node_to_split.getRight(), null, null, null, r);
				if (node_to_split.getRight_mid() != null)
				{/** make the parent of the rightmost nodes, the righttist node*/
					node_to_split.getRight_mid().setParent(righttist);
				}
				if (node_to_split.getRight() != null)
				{
					node_to_split.getRight().setParent(righttist);
				}

				root = new Dread_Node(lefttist, righttist, null, null, null, mid);//set the getLeft() and getRight() nodes to lefttist and righttist
				lefttist.setParent(root);//set the parents of the lefttist and righttist nodes to the root
				righttist.setParent(root);
			}
			else
			{

				if (node_to_split.getParent().getLeft_mid() != null && node_to_split.getParent().getRight() == node_to_split)
				{//if the parent node is a threenode and the current node is the getRight() side of the parrent node


					Dread_Node lefttist = new Dread_Node(node_to_split.getLeft(), node_to_split.getLeft_mid(), null, null, null, l);//take the leftmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called lefttist
					if (node_to_split.getLeft() != null)
					{/** make the parent of the leftmost nodes, the lefttist node*/
						node_to_split.getLeft().setParent(lefttist);
					}
					if (node_to_split.getLeft_mid() != null)
					{
						node_to_split.getLeft_mid().setParent(lefttist);
					}

					Dread_Node righttist = new Dread_Node(node_to_split.getRight_mid(), node_to_split.getRight(), null, null, null, r);//take the rightmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called righttist
					if (node_to_split.getRight_mid() != null)
					{/** make the parent of the rightmost nodes, the righttist node*/
						node_to_split.getRight_mid().setParent(righttist);
					}
					if (node_to_split.getRight() != null)
					{
						node_to_split.getRight().setParent(righttist);
					}


					node_to_split.getParent().setRight_mid(lefttist);//set the third node of the parent node to the lefttist node and set its parent to the parent of the node to split
					lefttist.setParent(node_to_split.getParent());




					node_to_split.getParent().setRight(righttist);//set the fourth node of the parent node to the rightttist node and set its parent to the parent of the node to split
					node_to_split = righttist;
					righttist.setParent(lefttist.getParent());

					insertnum(node_to_split.getParent(), mid);

				}
				else if (node_to_split.getParent().getLeft_mid() != null && node_to_split.getParent().getLeft() == node_to_split)
				{//if the parent node is a threenode and the current node is the leftt side of the parrent node


					Dread_Node lefttist = new Dread_Node(node_to_split.getLeft(), node_to_split.getLeft_mid(), null, null, null, l);//take the leftmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called lefttist
					if (node_to_split.getLeft() != null)
					{/** make the parent of the leftmost nodes, the lefttist node*/
						node_to_split.getLeft().setParent(lefttist);
					}
					if (node_to_split.getLeft_mid() != null)
					{
						node_to_split.getLeft_mid().setParent(lefttist);
					}

					Dread_Node righttist = new Dread_Node(node_to_split.getRight_mid(), node_to_split.getRight(), null, null, null, r);//take the rightmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called righttist
					if (node_to_split.getRight_mid() != null)
					{/** make the parent of the rightmost nodes, the righttist node*/
						node_to_split.getRight_mid().setParent(righttist);
					}
					if (node_to_split.getRight() != null)
					{
						node_to_split.getRight().setParent(righttist);
					}


					node_to_split.getParent().setRight_mid(node_to_split.getParent().getLeft_mid());//push the second child of the parent node to the third spot

					node_to_split.getParent().setLeft_mid(righttist);//make righttist the second child of the parent node and set its parent
					righttist.setParent(node_to_split.getParent());

					node_to_split.getParent().setLeft(lefttist);//make lefttist the leftmost child of the parent node and set its parent
					node_to_split = lefttist;
					lefttist.setParent(righttist.getParent());

					insertnum(node_to_split.getParent(), mid);
				}
				else if (node_to_split.getParent().getLeft_mid() == null && node_to_split.getParent().getRight() == node_to_split)
				{//if the parent node is not a threenode and the current node is the getRight() side of the parrent node


					Dread_Node lefttist = new Dread_Node(node_to_split.getLeft(), node_to_split.getLeft_mid(), null, null, null, l);//take the leftmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called lefttist
					if (node_to_split.getLeft() != null)
					{/** make the parent of the leftmost nodes, the lefttist node*/
						node_to_split.getLeft().setParent(lefttist);
					}
					if (node_to_split.getLeft_mid() != null)
					{
						node_to_split.getLeft_mid().setParent(lefttist);
					}

					Dread_Node righttist = new Dread_Node(node_to_split.getRight_mid(), node_to_split.getRight(), null, null, null, r);//take the rightmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called righttist

					if (node_to_split.getRight_mid() != null)
					{/** make the parent of the rightmost nodes, the righttist node*/
						node_to_split.getRight_mid().setParent(righttist);
					}
					if (node_to_split.getRight() != null)
					{
						node_to_split.getRight().setParent(righttist);
					}


					node_to_split.getParent().setLeft_mid(lefttist);//set the middle node to lefttist and ste its parent to the parent node
					lefttist.setParent(node_to_split.getParent());

					node_to_split.getParent().setRight(righttist);//set the getRight() node to righttist and ste its parent to the parent node
					node_to_split = righttist;
					righttist.setParent(lefttist.getParent());



					insertnum(node_to_split.getParent(), mid);

				}
				else if (node_to_split.getParent().getLeft_mid() == null && node_to_split.getParent().getLeft() == node_to_split)
				{//if the parent node is not a threenode and the current node is the leftt side of the parrent node


					Dread_Node lefttist = new Dread_Node(node_to_split.getLeft(), node_to_split.getLeft_mid(), null, null, null, l);//take the leftmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called lefttist
					if (node_to_split.getLeft() != null)
					{/** make the parent of the leftmost nodes, the lefttist node*/
						node_to_split.getLeft().setParent(lefttist);
					}
					if (node_to_split.getLeft_mid() != null)
					{
						node_to_split.getLeft_mid().setParent(lefttist);
					}

					Dread_Node righttist = new Dread_Node(node_to_split.getRight_mid(), node_to_split.getRight(), null, null, null, r);//take the rightmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called righttist
					if (node_to_split.getRight_mid() != null)
					{/** make the parent of the rightmost nodes, the righttist node*/
						node_to_split.getRight_mid().setParent(righttist);
					}
					if (node_to_split.getRight() != null)
					{
						node_to_split.getRight().setParent(righttist);
					}


					node_to_split.getParent().setLeft_mid(righttist);//set the middle node to rightist and ste its parent to the parent node
					righttist.setParent(node_to_split.getParent());

					node_to_split.getParent().setLeft(lefttist);//set the getLeft() node to leftttist and ste its parent to the parent node
					node_to_split = lefttist;
					lefttist.setParent(righttist.getParent());

					insertnum(node_to_split.getParent(), mid);
				}
				else if (node_to_split.getParent().getLeft_mid() == node_to_split)
				{//if the current node is the middle node of the parent node

					Dread_Node lefttist = new Dread_Node(node_to_split.getLeft(), node_to_split.getLeft_mid(), null, null, null, l);//take the leftmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called lefttist
					if (node_to_split.getLeft() != null)
					{/** make the parent of the leftmost nodes, the lefttist node*/
						node_to_split.getLeft().setParent(lefttist);
					}
					if (node_to_split.getLeft_mid() != null)
					{
						node_to_split.getLeft_mid().setParent(lefttist);
					}

					Dread_Node righttist = new Dread_Node(node_to_split.getRight_mid(), node_to_split.getRight(), null, null, null, r);//take the rightmost sided nodes of the current node and make them into a into a getLeft() and getRight() node of a new node called righttist
					if (node_to_split.getRight_mid() != null)
					{/** make the parent of the rightmost nodes, the righttist node*/
						node_to_split.getRight_mid().setParent(righttist);
					}
					if (node_to_split.getRight() != null)
					{
						node_to_split.getRight().setParent(righttist);
					}



					node_to_split.getParent().setRight_mid(righttist);//set the third node to righttist and set re-adjust its parent
					righttist.setParent(node_to_split.getParent());

					node_to_split.getParent().setLeft_mid(lefttist);//set the second node to lefttist and set re-adjust its parent
					lefttist.setParent(righttist.getParent());

					insertnum(node_to_split.getParent(), mid);
				}

			}

		}


		public void Preorderprint(Dread_Node rt)
		{//prints the preorder of the tree

			if (rt == null)
			{//if tree is empty, go back

				return;
			}


			if (rt.arr[0] != -1)
			{//if getLeft() value isn't empty, print it

				System.out.print(rt.arr[0] + " ");


			}


			if (rt.arr[1] != -1)
			{//if getRight() value isn't empty, print it

				System.out.print(rt.arr[1] + " ");

			}

			Preorderprint(rt.getLeft());//recursively go getLeft()

			Preorderprint(rt.getLeft_mid());//recursively go center

			Preorderprint(rt.getRight());//recursively go getRight()
		}
		
		public void Postorderprint(Dread_Node rt)
		{//prints the postorder of the tree
			
			if (rt == null)
			{//if tree is empty, go back

				return;
			}
			
			Postorderprint(rt.getLeft());//recursively go getLeft()

			Postorderprint(rt.getLeft_mid());//recursively go center

			Postorderprint(rt.getRight());//recursively go getRight()


			if (rt.arr[0] != -1)
			{//if getLeft() value isn't empty, print it

				System.out.print(rt.arr[0] + " ");


			}


			if (rt.arr[1] != -1)
			{//if getRight() value isn't empty, print it

				System.out.print(rt.arr[1] + " ");

			}


		}

		public void Inorderprint(Dread_Node rt)
		{//prints the inorder of the tree
			
			if (rt == null)
			{//if tree is empty, go back

				return;
			}
			
			Inorderprint(rt.getLeft());//recursively go getLeft()
			
			if (rt.arr[0] != -1)
			{//if getLeft() value isn't empty, print it

				System.out.print(rt.arr[0] + " ");


			}


			if (rt.arr[1] != -1)
			{//if getRight() value isn't empty, print it

				System.out.print(rt.arr[1] + " ");

			}

			Inorderprint(rt.getLeft_mid());//recursively go center

			Inorderprint(rt.getRight());//recursively go getRight()


		}





	}