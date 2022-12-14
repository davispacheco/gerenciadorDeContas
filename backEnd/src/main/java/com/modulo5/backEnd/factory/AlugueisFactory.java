package com.modulo5.backEnd.factory;

import com.modulo5.backEnd.enums.RecebimentoAlugueis;
import com.modulo5.backEnd.model.ContasAReceberModel;

public class AlugueisFactory {
    public CalculoAlugueis getCalculoAluguel(ContasAReceberModel contasAReceberModel) {
        if (contasAReceberModel.getRecebimentoAlugueis().equals(RecebimentoAlugueis.ADIANTADO)) {
            return new CalculoAlugueisAdiantado();
        } else if (contasAReceberModel.getRecebimentoAlugueis().equals(RecebimentoAlugueis.EM_DIA)) {
            return new CalculoAlugueisEmDia();
        } else if (contasAReceberModel.getRecebimentoAlugueis().equals(RecebimentoAlugueis.EM_ATRASO)) {
            return new CalculoAlugueisEmAtraso();
        } else {
            return null;
        }
    }
}
