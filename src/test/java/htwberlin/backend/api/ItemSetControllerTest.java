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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemSetController.class)
class ItemSetControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemSetService service;



    @Test
    @DisplayName("Testing createItemSet, JSON is a valid ItemSet object")
    void createItemSet() {
    }

    @Test
    @DisplayName("Testing createItemSet, JSON is not a valid ItemSet object")
    void createItemSetWrongStructure() {
    }

    @Test
    @DisplayName("Testing get - ItemSet exists")
    void getItemSet() throws Exception {

        ItemSet set = new ItemSet("TestSet");
        set.setPrimKey(17L);
        when(service.get(17L)).thenReturn(set);

        String expected = "{\"primKey\":17,\"title\":\"TestSet\"," +
                "\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[{\"primKey\":null,\"type\":\"New Block\",\"items\":[]}]}";

        this.mockMvc.perform(get("/itemsets/17"))
                .andExpect(status().isOk())
                .andExpect( content().contentType(MediaType.APPLICATION_JSON))
                .andExpect( content().string(containsString(expected)));
    }

    @Test
    @DisplayName("Testing get - ItemSet doesn't exist")
    void getItemSetNonExisting() throws Exception {

        doReturn(null).when(service).get(1L);

        mockMvc.perform(get("/itemsets/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Testing getAll")
    void getAllItemSets() throws Exception {

        ItemSet set1 = new ItemSet("TestSet1");
        set1.setPrimKey(17L);
        ItemSet set2 = new ItemSet("TestSet2");
        set2.setPrimKey(18L);
        List<ItemSet> setList= new ArrayList<>();
        setList.add(set1);
        setList.add(set2);
        when(service.getAll()).thenReturn(setList);

        String expected = "[{\"primKey\":17,\"title\":\"TestSet1\"," +
                "\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[{\"primKey\":null,\"type\":\"New Block\",\"items\":[]}]}," +
                "{\"primKey\":18,\"title\":\"TestSet2\"," +
                "\"associatedMaps\":[11,12],\"associatedChampions\":[]," +
                "\"blocks\":[{\"primKey\":null,\"type\":\"New Block\",\"items\":[]}]}]";


        this.mockMvc.perform(get("/itemsets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("Testing deleteItemSet - item exists")
    void deleteItemSet() {
    }

    @Test
    @DisplayName("Testing deleteItemSet - item doesn't exist")
    void deleteItemSetNonExisting() {
    }


}