LIB_ANTLR := lib/antlr.jar
ANTLR_SCRIPT := Micro.g4

all: group compiler

group:
	@echo "Huayi Guo"
compiler:
	rm -rf build
	mkdir build
	java -cp $(LIB_ANTLR) org.antlr.v4.Tool -o build $(ANTLR_SCRIPT)
	rm -rf classes
	mkdir classes
	javac -cp $(LIB_ANTLR) -d classes src/*.java build/*.java
clean:
	rm -rf classes build
test:
	java -cp lib/antlr.jar:classes/ Micro input/step4_testcase.micro > testout
	tiny testout > out
	tinyR outputs/test > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
	java -cp lib/antlr.jar:classes/ Micro input/step4_testcase2.micro > testout
	tiny testout > out
	tinyR outputs/test1 > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
	java -cp lib/antlr.jar:classes/ Micro input/step4_testcase3.micro > testout
	tiny testout > out
	tinyR outputs/test2 > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
	java -cp lib/antlr.jar:classes/ Micro input/test_dowhile.micro > testout
	tiny testout > out
	tinyR outputs/test3 > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
	java -cp lib/antlr.jar:classes/ Micro input/test_if.micro > testout
	tiny testout > out
	tinyR outputs/test4 > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
	java -cp lib/antlr.jar:classes/ Micro input/test_adv.micro > testout
	tiny testout > out
	tinyR outputs/test5 > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
	java -cp lib/antlr.jar:classes/ Micro input/fac2.micro > testout
	tiny testout > out
	tinyR outputs/test6 > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
	java -cp lib/antlr.jar:classes/ Micro input/fma.micro > testout
	tiny testout > out
	tinyR outputs/test7 > sout
	echo `head -n 4 out` 
	echo `head -n 4 sout`
	java -cp lib/antlr.jar:classes/ Micro input/test_expr.micro > testout
	tiny testout > out
	tinyR outputs/test8 > sout
	echo `head -n 1 out` 
	echo `head -n 1 sout`
.PHONY: all group compiler clean
