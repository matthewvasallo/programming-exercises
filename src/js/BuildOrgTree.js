function Employee(name, title, manager) {
    var directReports = [];
    if (manager) {
        manager.addDirectReport(this);
    }

    this.addDirectReport = function (employee) {
        directReports.push(employee);
    };

    this.getDirectReports = function () {
        return directReports;
    };

    this.getName = function () {
        return name;
    };

    this.getTitle = function () {
        return title;
    };
}

Employee.prototype.getReportingChain = function (level) {
    var currentLevel = !level ? 1 : level;
    var reportChainSymbols = Array(currentLevel).join(Employee.ReportingChainSymbol);
    var reportChain = reportChainSymbols + this.getName() + " (" + this.getTitle() + ")" + "\n";
    currentLevel++;
    this.getDirectReports().forEach(function (empl) {
        reportChain += empl.getReportingChain(currentLevel);
    });
    return reportChain;
};

Employee.ReportingChainSymbol = "-";

var chuck = new Employee("Chuck Norris", "CEO", undefined);
var tom = new Employee("Tom Clancy", "Director", chuck);
var william = new Employee("William Wallace", "Director", chuck);
var jack = new Employee("Jack Bauer", "Manager", tom);
var indiana = new Employee("Indiana Jones", "Manager", william);
var darth = new Employee("Darth Vader", "Developer", jack);
var luke = new Employee("Luke Skywalker", "Developer", jack);
var han = new Employee("Han Solo", "Developer", indiana);
var james = new Employee("James Bond", "Intern", luke);
var frodo = new Employee("Frodo Baggins", "Intern", han);

console.log(chuck.getReportingChain());

Employee.ReportingChainSymbol = ">";
console.log(chuck.getReportingChain());
