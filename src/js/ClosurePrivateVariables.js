/*
 The current counter object has an exposed internal count which is accessible to the outside world.
 Create a new counter object with an encapsulated "private" count.
 */
var counter = {
    count: 0,
    incrementCount: function () {
        this.count++;
    },
    getCount: function () {
        return this.count;
    }
};

function createCounter() {
    var count = 0;
    return {
        incrementCount: function () {
            return count++;
        },
        printCount: function () {
            return count;
        }
    }
}

//Assign a new counter here.

counter.count = 5; //This should have no impact on the internal count, but currently it does!
counter.incrementCount();
console.log("Internal count is " + counter.getCount()); //This should print 2, but currently prints 6!