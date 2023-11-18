package tvnz.interview.challange.ui.steps;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.java8.En;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;

public class Hooks implements En{
    private final ObjectMapper objectMapper = new ObjectMapper();
    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }
}
