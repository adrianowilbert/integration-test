package integrationTests.utils;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class EnvironmentSetting {

    private DadosConfig dadosConfig;

    private Ambiente getAmbiente() {
        return dadosConfig.getConfig().getAmbientes()
            .stream()
            .filter(a -> a.getNome().equalsIgnoreCase(dadosConfig.getConfig().getAmbiente()))
            .findFirst()
            .get();
    }

    public String getBaseUrl() {
        return getAmbiente().getBaseUrl();
    }

    private static class SingletonHolder {

        private static final EnvironmentSetting INSTANCE = new EnvironmentSetting();
    }

    @SneakyThrows
    private EnvironmentSetting() {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        final DadosConfig dadosConfig = objectMapper.readValue(new File("src/test/resources/application.yml"),
            DadosConfig.class);
        this.dadosConfig = dadosConfig;
    }

    public static EnvironmentSetting getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static class DadosConfig {
        private Config config;

        public Config getConfig() {
            return config;
        }

        public void setConfig(final Config config) {
            this.config = config;
        }
    }

    public static class Config {

        private String ambiente;
        private List<Ambiente> ambientes;

        public String getAmbiente() {
            return ambiente;
        }

        public void setAmbiente(final String ambiente) {
            this.ambiente = ambiente;
        }

        public List<Ambiente> getAmbientes() {
            return ambientes;
        }
    }

    public static class Ambiente {

        private String nome;
        private String baseUrl;

        public String getNome() {
            return nome;
        }

        public void setNome(final String nome) {
            this.nome = nome;
        }


        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(final String baseUrl) {
            this.baseUrl = baseUrl;
        }

    }
}

