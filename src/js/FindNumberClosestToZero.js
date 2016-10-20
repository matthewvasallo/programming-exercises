function findClosestToZero(numbersArray) {
    var closestToZero = numbersArray[0];

    for (var i = 1; i < numbersArray.length; i++) {
        var isLessThanCurrentValue = Math.abs(numbersArray[i]) < Math.abs(closestToZero);
        var isValidTie = Math.abs(numbersArray[i]) === Math.abs(closestToZero) && numbersArray[i] > 0;

        if (isLessThanCurrentValue || isValidTie) {
            closestToZero = numbersArray[i];
        }
    }
    return closestToZero;
}

console.log("Expected [1, 2, 3] to be 1 and was " + findClosestToZero([1, 2, 3]));
console.log("Expected [-5,4,7,-2] to be -2 and was " + findClosestToZero([-5,4,7,-2]));