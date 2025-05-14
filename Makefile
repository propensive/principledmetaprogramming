test:
	mill metaprogramming.test.assembly
	java -cp out/metaprogramming/test/assembly.dest/out.jar metaprogramming.Tests

