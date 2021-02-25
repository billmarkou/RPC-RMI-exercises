struct inputsMo 
	{
		int resultMo;
		int b<5>;
	};

struct inputsMinMax 
	{
		int minMax<2>;
		int b<5>;
	};

struct inputsMul 
	{
		int mult;
		int mulArr<5>;
		int b<5>;
	};

program ask_PROG {
		version ask_VERS {
			inputsMo mo(inputsMo) = 1;
			inputsMinMax minmax(inputsMinMax) = 2;
			inputsMul mul(inputsMul) = 3; 
	} = 1;

} = 0x23451111;
