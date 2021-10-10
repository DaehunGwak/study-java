package io.ordi.refactoring.ch06.item02;

public class InlineFunction {

    private class Before {
        public long getRating(Driver driver) {
            return moreThanFiveLateDeliveries(driver) ? 2 : 1;
        }

        private boolean moreThanFiveLateDeliveries(Driver driver) {
            return driver.getNumberOfLatDeliveries() > 5;
        }
    }

    private class After {
        public long getRating(Driver driver) {
            return (driver.getNumberOfLatDeliveries() > 5) ? 2 : 1;
        }
    }

    private class Driver {
        public long getNumberOfLatDeliveries() {
            return 10; // mock
        }
    }
}
