function computeFactorial(number) {
    return (number <= 1) ? number : number * computeFactorial(number - 1);
}

console.log("Factorial of 1 is " + computeFactorial(1));
console.log("Factorial of 2 is " + computeFactorial(2));
console.log("Factorial of 3 is " + computeFactorial(3));
console.log("Factorial of 5 is " + computeFactorial(5));
console.log("Factorial of -1 is " + computeFactorial(-1));