# Linear Regression

See the Linear Regression algorithm in use with some data points.

## The Hypothesis

Remember the equation of a straight line? It maps some inputs, x, to the output, y.

    y = mx + c

With Linear Regression, we're looking for the m and c that transform the input data x, to some line, h(x).

![](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/resources/hypothesis.png)

By convention, we use 'theta', θ, the 0 with the line through. The θ1 is is often refered to as a 'weight', as it scales the input data x. The θ0 is often refered to as a 'bias', which acts as the y intercept.
The θ values are going to map x to some output line, the hypothesis h(x). 

The idea with the hypothesis, h(x), is to get outputs that are as close to y as possible.

In this example, the input data, x, is the size of a house in square feet.
The output is the price, in 1000s.

## The Cost Function

To work out how close the hypothesis is to the 'real' answers, we use the cost function. This is sometimes known as the 'error'.

It looks at the difference between what the hypothesis outputs, and the example data. The idea is to get a hypothesis that generalises well to unseen, new example data.

![](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/resources/cost.png)

## Gradient Descent

Once we have a way of measuring the 'cost' of a hypothesis - or error, we can automate minimising it.
For gradient descent, we simulatenously update the theta, weight, values. 
For this purpose, imagine x is a vector:

     x0 
  
     x1

where x0 is 1. This is for the bias, θ0.

This is for when we have hypotheses with more than one input variable. For example, instead of just:

    x = size in sqaure feet

    y = house price

We might have:

    x1 = size in sqaure feet

    x2 = number of bedrooms

    x3 = number of bathrooms... etc.

Then we want to know what the 'weight' of each of them is on the output, so we'll want to find a corresponding theta for each of them.

![](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/resources/Gradient%20descent.png)

What this is doing is adjusting the theta values a little bit each time. We're going to look at what this means.
Take note of the α symbol - this is 'alpha'.

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
