public class Dread_Node
	{

		protected Dread_Node left;//points to the left node of the current node



		public Dread_Node getLeft()
		{
			return left;
		}

		public void setLeft(Dread_Node left)
		{
			this.left = left;
		}


		protected Dread_Node right;//points to the right node of the current node 




		public Dread_Node getRight()
		{
			return right;
		}

		public void setRight(Dread_Node right)
		{
			this.right = right;
		}



		protected Dread_Node left_mid;//this will be used as the default mid pointer


		public Dread_Node getLeft_mid()
		{
			return left_mid;
		}

		public void setLeft_mid(Dread_Node left_mid)
		{
			this.left_mid = left_mid;
		}


		protected Dread_Node right_mid;//exists as a concept to hold values as the third child node of a temporary four node



		public Dread_Node getRight_mid()
		{
			return right_mid;
		}

		public void setRight_mid(Dread_Node right_mid)
		{
			this.right_mid = right_mid;
		}



		protected Dread_Node parent;//points to the parent node of the current node


		public Dread_Node getParent()
		{
			return parent;
		}

		public void setParent(Dread_Node parent)
		{
			this.parent = parent;
		}


		public int[] arr;//holds the values of a node 


		protected int refer;//keeps track of the number of values in a the current node 
	
	
	
	public int getRefer()
		{
			return refer;
		}

		public void setRefer(int refer)
		{
			this.refer = refer;
		}

		public Dread_Node()
		{//sets the all pointers to zero and the refererence value to the first number in the array to zero 

			left = right = left_mid = right_mid = parent = null;

			arr = new int[3];
			arr[0] = arr[1] = arr[2] = -1;

			refer = 0;

		}


		public boolean nochildren()
		{//checks to see if the node has any children

			if (left == null && right == null && left_mid == null && right_mid == null)
			{

				return true;
			}

			return false;
		}

		public Dread_Node(Dread_Node newleft, Dread_Node newright, Dread_Node newleftmid, Dread_Node newrightmid, Dread_Node newparent, int newnumput)
		{//sets the parent, children ,the arrays and the refererence 

			left = newleft;
			right = newright;
			left_mid = newleftmid;
			right_mid = newrightmid;
			parent = newparent;

			refer = 0;

			arr = new int[3];
			arr[0] = arr[1] = arr[2] = -1;
			arr[refer ++] = newnumput;


		}




	}