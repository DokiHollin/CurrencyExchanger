import java.util.List;

public class User {
    protected List<Rate> rateList;

    public User(List<Rate> rateList) {
        this.rateList = rateList;
    }

    public List<Rate> getRateList() {
        return rateList;
    }
}
