package htwberlin.backend.dbmethods;


import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class ItemSetServiceTest implements WithAssertions {

    @Mock
    ItemSetRepository repo;
    @InjectMocks
    ItemSetService itemSetService;

    @Test
    @DisplayName("Test get method")
    void testGet(){
    }

    @Test
    @DisplayName("Test getAll method")
    void testGetAll(){
    }

    @Test
    @DisplayName("Test deleteById method")
    void testDeleteById(){
    }

    @Test
    @DisplayName("Test Save method")
    void testSave(){
    }

}
