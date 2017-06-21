# Linear Regression

See the Linear Regression algorithm in use with some data points.

## The Hypothesis

Remember the equation of a straight line? It maps some inputs, x, to the output, y.

    y = mx + c

With Linear Regression, we're looking for the m and c that transform the input data x, to some line, h(x).

![](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/resources/images/hypothesis.png)

By convention, we use 'theta', θ, the 0 with the line through. The θ1 is is often refered to as a 'weight', as it scales the input data x. The θ0 is often refered to as a 'bias', which acts as the y intercept.
The θ values are going to map x to some output line, the hypothesis h(x). 

The idea with the hypothesis, h(x), is to get outputs that are as close to y as possible.

In this example, the input data, x, is the size of a house in square feet.
The output is the price, in 1000s.

## The Cost Function

To work out how close the hypothesis is to the 'real' answers, we use the cost function. This is sometimes known as the 'error'.

It looks at the difference between what the hypothesis outputs, and the example data. The idea is to get a hypothesis that generalises well to unseen, new example data.

![](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/resources/images/cost.png)

## Gradient Descent

Once we have a way of measuring the 'cost' of a hypothesis - or error, we can automate minimising it.
For gradient descent, we simultaneously update the theta, weight, values. 
For this purpose, imagine x is a vector:

     x0 
  
     x1

where x0 is 1. This is for the bias, θ0. So instead of 

     y = mx + c

we could write

    h(x) = (θ1 * x1) + θ0

or

    h(x) = (θ1 * x1) + (θ0 * 1) = (θ1 * x1) + (θ0 * x0)

This is for when we have hypotheses with more than one input variable. For example, instead of just:

    x = size in square feet

    y = house price

We might have:

    x1 = size in square feet

    x2 = number of bedrooms

    x3 = number of bathrooms... etc.

Then we want to know what the 'weight' of each of them is on the output, so we'll want to find a corresponding theta for each of them, e.g.:

    h(x) = (θ0 * x0) + (θ1 * x1) + (θ2 * x2) + (θ3 * x3) + ....


![](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/resources/images/Gradient%20descent.png)

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
3. What part does alpha play in a step of gradient descent? (Hint: what happens when it is too big? What happens when it is too small?).
4. How do you think gradient descent works? 
5. Tweet a sentence on 
 - how gradient descent works, and/or
 - what supervised learning is
6. What do you think the limits are?

## I'm going to need more information. Especially on the maths.

No problem! Have a look at [this step-by-step guide](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/resources/Linear%20Regression%20notes.pdf).

## Tips / I'm stuck

1. Press reset / start with a fresh application.

2. Using the θ1 button, increase the gradient. Going from θ1 =1 to θ1 =2, what do you notice about the cost?

3. Now, press 'Take gradient descent step' a few times. What happens? 

4. Decrease the learning rate.

5. Press 'Take gradient descent step' a few times now. What happens? 

6. Look at the code in [GradientDescentStep](https://github.com/katharinebeaumont/Linear-Regression/blob/master/src/linear/regression/calculations/GradientDescentStep.java) and write out, in plain language, what it's doing.
Compare your notes to what you've seen. Do you have an idea of how alpha affects the size of the step? 

## There's a bug!

Open an issue or DM me on [Twitter](https://twitter.com/katharineCodes) for my e-mail address.
