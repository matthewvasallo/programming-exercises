function findFirstDuplicateNumber(numberArray) {
    let numbersSeen = {};
    for (var i = 0; i < numberArray.length; i++) {
        let currentNumber = numberArray[i];
        if (numbersSeen[currentNumber]) {
            return currentNumber;
        } else {
            numbersSeen[currentNumber] = true;
        }
    }
    return "no duplicates found";
}

console.log("Found first duplicate in [6, 3, 1, 4, 7, 4, 2, 8, 9, 2] to be", findFirstDuplicateNumber([6, 3, 1, 4, 7, 4, 2, 8, 9, 2]));
console.log("Found first duplicate in [6, 3, 1, 4] to be", findFirstDuplicateNumber([6, 3, 1, 4]));