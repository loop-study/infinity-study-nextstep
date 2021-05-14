package lotto01.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 티켓들")
public class LottoTicketsTest {

    List<Integer> manualLotto() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    List<List<Integer>> createManualLottos(int quantity) {
        return Stream.generate(this::manualLotto)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,5","1000,1"})
    public void 로또_자동_발행(int buyAmount, int ticketCount) throws Exception {
        LottoTickets lottoTickets = new LottoTickets(buyAmount);
        assertThat(lottoTickets.lottoTickets().size()).isEqualTo(ticketCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"5","1"})
    public void 로또_수동_발행(int ticketCount) throws Exception {
        LottoTickets lottoTickets = new LottoTickets(createManualLottos(ticketCount));
        assertThat(lottoTickets.lottoTickets().size()).isEqualTo(ticketCount);
    }
}
