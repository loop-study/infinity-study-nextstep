package lotto01.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int autoAmount) {
        return new LottoTickets(createAutoLottoTickets(autoAmount));
    }

    public static LottoTickets of(List<List<Integer>> manualNumbers) {
        return new LottoTickets(createManualLottoTickets(manualNumbers));
    }

    public static LottoTickets ofTickets(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
        List<LottoTicket> totalTickets = new ArrayList<>();
        totalTickets.addAll(manualLottoTickets.lottoTickets());
        totalTickets.addAll(autoLottoTickets.lottoTickets());

        return new LottoTickets(totalTickets);
    }

    private static List<LottoTicket> createManualLottoTickets(List<List<Integer>> manualNumbers) {
        return  manualNumbers.stream()
                .map(LottoTicket::of)
                .collect(Collectors.toList());
    }

    private static List<LottoTicket> createAutoLottoTickets(int amount) {
        return Stream.generate(LottoTicket::of)
                .limit(amount / LOTTO_PRICE)
                .collect(Collectors.toList());
    }

    public List<LottoTicket> lottoTickets() {
        return lottoTickets;
    }
}
