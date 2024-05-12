package amigoscode.Stream;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String args[]){
        List<String> names=List.of("Jamila","Alex","Mariam");
        names.stream().forEach(System.out::println);
       // names.stream().forEach(name->System.out.println(name));
       //Consumer<String> stringConsumer=name-> System.out.println(name);
       //names.forEach(stringConsumer);
    }
}
//we can use lambdas in forEach
//Consumer consumes something and doesnot return anything