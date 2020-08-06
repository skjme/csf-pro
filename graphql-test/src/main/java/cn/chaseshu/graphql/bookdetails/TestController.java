package cn.chaseshu.graphql.bookdetails;

import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("graphql")
@RestController
public class TestController {

    @Autowired
    private GraphQLProvider provider;

    @RequestMapping
    public ExecutionResult test(@RequestParam("book_id") String book_id){

        ExecutionResult result = provider.graphQL().execute("{ bookById(id:\""+book_id+"\"){id, name, pageCount, author{id, firstName, lastName}}}");
        return result;
    }
}
