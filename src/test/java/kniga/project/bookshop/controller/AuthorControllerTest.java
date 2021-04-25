package kniga.project.bookshop.controller;

import antlr.build.Tool;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.status.AuthorStub;
import kniga.project.bookshop.status.BookStub;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@AutoConfigureMockMvc
//@WebMvcTest(AuthorController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorControllerTest {

    @MockBean
    private AuthorRepository authorRepository;

    @Autowired
    private MockMvc mockMvc;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSuccessfulDeleteAuthor() throws Exception {
        Author author = AuthorStub.getRandomAuthor();
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author);
        mockMvc.perform(delete("/v1/authors/1")
                .content("1"))
                .andExpect(status().isOk())
                .andDo(print());
    }



}