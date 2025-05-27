package demoApplicationSACAViX;

public class Phone {

    private Long id;
    private String name;

    public Phone() {
    }

    public Phone(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }
}
