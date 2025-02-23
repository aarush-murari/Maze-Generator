package mazePackage;

import java.util.NoSuchElementException;

public class MazeNode {
	private MazeNode[] childList;
	private int cListCounter;
	
	public MazeNode() {
		cListCounter = 0;
		childList = new MazeNode[4];
	}
	
	public MazeNode(MazeNode child) {
		cListCounter = 0;
		childList = new MazeNode[4];
		addChild(child);
	}
	
	
	public void addChild(MazeNode child) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		
		if (cListCounter >= 3) {
			throw new IndexOutOfBoundsException("Node cannot have more than four children.");
		}
		
		if (!this.hasChild(child)) {

			childList[cListCounter] = child;
			cListCounter++;
		}
		
	}

	
	
	public int getChildCount() {
		return cListCounter + 1;
	}
	
	
	public void removeChild(MazeNode childNode) throws NoSuchElementException{
		if (this.hasChildren()) {
			int index = this.indexOf(childNode);
			childList[index] = childList[4];
			childList[4] = null;
			cListCounter--;
			
		}
		
		throw new NoSuchElementException("Node has no children to remove.");
	}
	
	public boolean hasChildren() {
		boolean hasChildren = false;
		for (MazeNode i : childList) {
			 if (i != null) {
				 hasChildren = true; 
			 }
		}
		return hasChildren;
	}
	
	
	public int indexOf(MazeNode childNode) throws NoSuchElementException{
		
		for (int i = 0; i < childList.length; i++) {
			MazeNode child = childList[i];
			 if ((child != null) && child.equals(childNode)) {
				 return i;
			 }
		}
		
		throw new NoSuchElementException("Node is not a valid child");
	}
	
	public boolean hasChild(MazeNode child) {
		boolean isChild = false;
		for (MazeNode i : childList) {
			 if ((i != null) && i.equals(child)) {
				 isChild = true; 
				 break;
			 }
		}
		return isChild;
	}
	
	public boolean equals(MazeNode child) {
		return ((child != null) && (this == child));
	}
	
	
	
}
