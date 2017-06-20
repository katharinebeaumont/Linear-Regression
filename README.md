# Linear Regression

See the Linear Regression algorithm in use with some data points.

## The Hypothesis


## The Cost Function


## Gradient Descent


## Alpha - the Learning Rate

The Learning Rate. For the purpose of this exercise, the learning rate displayed on
the slider is scaled up by a factor of 10,000. When used in the gradient descent step, it
1 is actually 0.0001.

## Get started

You will need: [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and preferably, [Netbeans](https://netbeans.org/) which has support for JavaFX projects and Ant.

Either build the jar using build.xml, then run `java -jar dist/Linear Regression.jar` or (in an IDE) run the project from src/linear/regression/LinearRegression.java.

Start the program. You need to:
1. Play with changing theta1 and see how it affects the cost.
2. Find the range of alpha at which gradient descent will converge to the value of 
theta1 where the cost is lowest.
3. What part does alpha play in a step of gradient descent?
4. How do you think the linear regression algorithm works? 