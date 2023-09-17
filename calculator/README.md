# calculator
## functions
1. The calculator support basic calculation operation ( ^ + - * / %) and logical operation (< > \ & = ).
2. The calculator contains graphic user interface.
3. The calculator can report the error in the input mathematics expression such as incorrect parenthesis numbers or excessive operators. 
4. The calculator do not support unary, sin,cos,tan. When expression include these words, calculator will report error.
5. The calculator accept operator expression without any space between operators.
## preOperation
### mainOpt
this method put the expression into correct function(logical operations and algebra operation)
### parenthesisCheck 
this method check for parenthesis correctness in the expression with stack. The stack will push all the '(' and ').
And char in current loop is ')' and the top of the stack is '(' the stack will pop out. So if the number and order of the parenthesis is correct, the size of stacks should be zero.
### logicalCheck
This method check if the expression contain signs like( <, >, =, !, &, | ). The methods return true when the expression contains logical operations and false otherwise.
## algerbraOperation
this class contains methods for calculation 
### algrebraTransform
the methods is kind of the main method of the class
### inToPost
The methods turn a normal expression into the postfix expression in queue form. 
Basically the methods traverse the whole expressions. Check the current char to algebra or operator.
If the char represent the number, it goes into the stack directly. 
If it's a operator, the method will check the stack of operator. If the top of the stack has greater level, then it will be pop into the queue.

### evlPost 
traverse over the input queue. put numbers into the stack. When it reaches the operator it will call the calculateOpt method.

### optLevel 
return the level of different operators. 

| level | operation |
|-------|-----------|
| 4     | ^         |
| 3     | *         |
| 3     | /         |
| 3     | %         |
| 2     | +         |
| 2     | -         |
| (     | -1        |

### calculateOpt
perform the different mathematics operation. It takes in the char represents different operators. and using switch statement to apply different math operations.
It will return "B" when the denominator is 0.
## logicOperation
### inToPost
The methods turn a normal expression into the postfix expression in queue form.
Basically the methods traverse the whole expressions. Check the current char to algebra or operator.
If the char represent the number, it goes into the stack directly.
If it's a operator, the method will check the stack of operator. If the top of the stack has greater level, then it will be pop into the queue.
### evlPost
traverse over the input queue. put numbers into the stack. When it reaches the algebra operator it will call the calculateOpt method.
When it reaches logic operator it calls combination
### optLevel
return the level of different operators. 

| level       | operation |
|-------------|-----------|
| 4           | ^         |
| 4           | !         |
| 3           | *         |
| 3           | /         |
| 3           | %         |
| 2           | +         |
| 2           | -         |
| <           | 1         |
| larger than | 1         |
| =           | 1         |
| or          | 1         |
| &           | 1         |
| (           | -1        |

## in
this class is provided in the previous lab and made by Robert Sedgewick and Kevin Wayne. More citation details can be found in the class file.

## fileGen
this is the class that turn the result into txt file
## calStack
extend form the calList. Elements in the class are first in last out. 

## calQueue
extend from the callist. elements in the class are first in first out.

## callist
this class is linked list.

## node
this is the basic node for the linked list. Inlude the value and the pointers to the next nodes. 

## output1.txt
this file is the output file of URCalculator with input input.txt file.
## output.txt
this file is the output file of URCalculator with input test.txt file. 




