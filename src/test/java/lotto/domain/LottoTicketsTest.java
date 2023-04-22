package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    @DisplayName("티켓들 안의 티켓 하나하나가 모두 다른 6개의 숫자로 이루어져 있는가")
    void z() throws Exception{
        LottoTickets lottoTickets = new LottoTickets(6);
        assertEquals(6,lottoTickets.getLottoTickets().size());
        for(Lotto lotto : lottoTickets.getLottoTickets()){
            assertTrue((int)lotto.getNumbers().stream().distinct().count() == 6);
        }
    }

}