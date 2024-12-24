@Default(value = String.class)
@ToString(value = "NO")
@Validate(value = {String.class, Integer.class})
@Two(first = "example", second = 42)
@Cache(value = {"key1", "key2"})
public class EClass {

    @Default(value = Integer.class)
    @ToString
    private int exampleField;

    @Invoke
    public void someMethod() {
    }
}