package github.lucasmartins.classes.exemploconsumidorsqs.listener;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    /**
     * Este método é o seu "consumidor". Graças à anotação @SqsListener, o Spring
     * irá automaticamente:
     * 1. Conectar-se à fila SQS especificada pelo nome.
     * 2. Ficar escutando por novas mensagens.
     * 3. Chamar este método para cada mensagem recebida, passando o corpo dela como parâmetro.
     * 4. Se o método executar sem erros, o Spring DELETARÁ a mensagem da fila automaticamente.
     *
     * @param messageBody O conteúdo (corpo) da mensagem SQS, que é o nosso JSON.
     * @param queueName   O nome da fila da qual a mensagem veio (ex: 'fila_aluno_joao').
     */
    @SqsListener("${sqs.queue.name}")
    public void processMessage(String messageBody) {
        logger.info(">>> MENSAGEM RECEBIDA! <<<");
        logger.info("Conteúdo: {}", messageBody);
    }
}