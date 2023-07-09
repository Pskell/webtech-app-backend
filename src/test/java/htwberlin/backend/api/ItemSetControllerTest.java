package htwberlin.backend.api;

import htwberlin.backend.data.ItemSet;
import htwberlin.backend.dbmethods.ItemSetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemSetController.class)
class ItemSetControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemSetService service;


    @Test
    @DisplayName("Test1; Testing createItemSet, JSON is a valid ItemSet object")
    void createItemSet() throws Exception {
        ItemSet set1 = new ItemSet("TestSet1");

        when(service.save(any(ItemSet.class))).thenReturn(set1);

        String request = "{\"title\":\"TestSet1\",\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[{\"type\":\"New Block\",\"items\":[]}]}";

        this.mockMvc.perform(post("/itemsets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk());
        verify(service, times(1)).save(set1);
    }



/*  Works fine in IntelliJ, causes the tests to stop running due to the ValidationError when run using gradlew test.
    (tests themselves don't fail) Would most likely need a separate Exception handler for the validation error to catch
    it beforehand.
    @Test
    @DisplayName("Test 2; Testing createItemSet, JSON is not a valid ItemSet object (no itemblock), " +
            "checking for a fully correct JSON structure currently not possible")
    void createItemSetWrongStructure() throws Exception {

        String request = "{\"title\":\"TestSet1\",\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[]}";

        this.mockMvc.perform(post("/itemsets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());
    }*/


    @Test
    @DisplayName("Test 3; Testing get - ItemSet exists")
    void getItemSet() throws Exception {

        ItemSet set1 = new ItemSet("TestSet1");
        Long primKey = 3L;
        set1.setPrimKey(primKey);
        when(service.get(primKey)).thenReturn(set1);

        String expected = "{\"primKey\":3,\"title\":\"TestSet1\"," +
                "\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[{\"primKey\":null,\"type\":\"New Block\",\"items\":[]}]}";

        this.mockMvc.perform(get("/itemsets/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
        verify(service, times(1)).get(primKey);
    }

    @Test
    @DisplayName("Test 4; Testing get - ItemSet doesn't exist")
    void getItemSetNonPresent() throws Exception {
        Long notExistingKey = 5L;
        doReturn(null).when(service).get(notExistingKey);

        mockMvc.perform(get("/itemsets/5"))
                .andExpect(status().isNotFound());
        verify(service, times(1)).get(notExistingKey);
    }

    @Test
    @DisplayName("Test 5; Testing getAll")
    void getAllItemSets() throws Exception {

        ItemSet set1 = new ItemSet("TestSet1");
        Long primKey1 = 7L;
        set1.setPrimKey(primKey1);
        ItemSet set2 = new ItemSet("TestSet2");
        Long primKey2 = 11L;
        set2.setPrimKey(primKey2);
        List<ItemSet> setList = new ArrayList<>();
        setList.add(set1);
        setList.add(set2);
        when(service.getAll()).thenReturn(setList);

        String expected = "[{\"primKey\":7,\"title\":\"TestSet1\"," +
                "\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[{\"primKey\":null,\"type\":\"New Block\",\"items\":[]}]}," +
                "{\"primKey\":11,\"title\":\"TestSet2\"," +
                "\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[{\"primKey\":null,\"type\":\"New Block\",\"items\":[]}]}]";


        this.mockMvc.perform(get("/itemsets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
        verify(service, times(1)).getAll();
    }

    @Test
    @DisplayName("Test 6; Testing deleteItemSet - item exists")
    void deleteItemSet() throws Exception {

        ItemSet set1 = new ItemSet("TestSet1");
        Long primKey = 13L;
        set1.setPrimKey(primKey);
        when(service.deleteById(13L)).thenReturn(true);
        this.mockMvc.perform(delete("/itemsets/13"))
                .andExpect(status().isOk());
        verify(service, times(1)).deleteById(primKey);
    }

    @Test
    @DisplayName("Test 7; Testing deleteItemSet - item doesn't exist")
    void deleteItemSetNonPresent() throws Exception {
        Long notExistingKey = 17L;
        when(service.deleteById(notExistingKey)).thenReturn(false);
        this.mockMvc.perform(delete("/itemsets/17"))
                .andExpect(status().isNotFound());
        verify(service, times(1)).deleteById(notExistingKey);
    }


}
