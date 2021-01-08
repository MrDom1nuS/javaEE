package mysql.cars;

public class TestRework {
	private TestCDI testCDI;

    @Inject
    public TestCDI(TestCDI testCDI) {
        this.testCDI = TestCDI;
    }
}
