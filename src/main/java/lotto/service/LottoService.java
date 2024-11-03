package lotto.service;

import java.util.List;
import lotto.common.RandomNumberGenerator;
import lotto.domain.IssuedLotto;
import lotto.domain.IssuedRandomLotto;
import lotto.domain.LottoProfitCalculator;
import lotto.domain.LottoResult;

public class LottoService {
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public IssuedRandomLotto createIssuedRandomLotto(int purchaseAmount) {
        IssuedRandomLotto issuedLotto = new IssuedRandomLotto(randomNumberGenerator, purchaseAmount);
        issuedLotto.generateIssuedLottos();
        return issuedLotto;
    }

    public LottoResult createLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(winningNumbers, bonusNumber);
    }

    public double calculateRateOfProfit(LottoProfitCalculator calculator) {
        calculator.calculateLottoStatistics();
        return calculator.calculateRateOfProfit();
    }

    public LottoProfitCalculator createLottoProfitCalculator(LottoResult lottoResult, IssuedLotto issuedLotto) {
        LottoProfitCalculator calculator = new LottoProfitCalculator(lottoResult, issuedLotto);
        return calculator;
    }
}