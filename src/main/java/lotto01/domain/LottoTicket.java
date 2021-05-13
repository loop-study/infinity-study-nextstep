package lotto01.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of() {
        return new LottoTicket(new ArrayList<>());
    }
}
