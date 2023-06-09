class Runner{

	public static void main(String[] args){

		DoubleVector vector = new DoubleVector();

		// #1
		System.out.println("\n\n\t==> Initialize!");

		System.out.println("\n\n\t=>BASIC FUNCTIONS TEST!!!");

		// #2
		System.out.println("\n# Is empty: " + vector.empty());
		System.out.println("\t=> Does a Push Back, with the value of 4.");
		vector.push_back(4);
		System.out.println("# Is empty: " + vector.empty());
		System.out.println("# Size = " + vector.size());

		// #3
		System.out.println("\n\t=> Gets a value out of the list");
		System.out.println("# Return of the second position of the list: " + vector.at(1));

		// #4
		System.out.println("\n\t=> Gets a value in the list");
		System.out.println("# Return of the first position of the list: " + vector.at(0));

		// #5
		System.out.println("\n\t=> Does a Pop Back");
		System.out.println("# Return value from Pop Back = " + vector.pop_back());
		System.out.println("# Size = " + vector.size());

		// #6
		System.out.println("\n\t+> Does a Pop Front");
		System.out.println("# Pop back return = " + vector.pop_back());
		System.out.println("# Size = " + vector.size());

		// #7
		System.out.println("\n\t=> Puts 4 and 5 with a Push Front");
		vector.push_front(4);
		vector.push_front(5);
		System.out.println("\t=> Does the print of the vector");
		vector.print();
		System.out.println("\n\t=> Does the reverse print of the vector");
		vector.printReverse();
		System.out.println("");

		// #8
		System.out.println("\n\t=> Creating a new Double Vector with the\n"
					+ "\t   same values of the one been used, but\n"
					+ "\t   instead using Push Back and a smaller capacity\n");
		DoubleVector anotherVector = new DoubleVector(1);
		anotherVector.push_back(5);
		anotherVector.print();
		System.out.println("\t=> Vector");
		anotherVector.push_back(4);
		System.out.println("\t=> Printing the new Double Vector");
		anotherVector.print();
		System.out.println("\n\t=> Checking the list of the old vector is equal to the newer vector");
		System.out.println("# The vectors have equal lists: " + vector.equal(anotherVector));

		// #9
		System.out.println("\n\t=> Concatenating the old vector with the newest\n"
					+ "\t   one and than the result with the oposite order.");
		vector.concat(anotherVector);
		vector.print();
		System.out.println("");
		System.out.println("Size = " + vector.size());
		anotherVector.concat(vector);
		vector.print();
		System.out.println("");
		System.out.println("Size = " + anotherVector.size());

		// #10
		System.out.println("\n\t=> Getting a new Double Vector full a couple of times with mutiple pushes");
		DoubleVector thirdVector = new DoubleVector();
		for(Integer i = 0; i < 200; i += 20)
			thirdVector.push_back(i);
		thirdVector.print();
		System.out.println("");
	}
}
