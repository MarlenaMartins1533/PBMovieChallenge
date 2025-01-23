PBMovieChallenge

https://github.com/user-attachments/assets/92b5fefd-ef9d-4c1c-ad94-8c3d23340841


- Desenvolvido utilizando o Android Studio na linguagem kotlin.
- Arquitetura de software
    - Utilizo a arquitetura Clean Arch para montar a estrutura da aplicação,
        - data para gestão dos recursos externos a api.
        - o domain para lógica da app
        - presentation para Ui.
    - Utilizo a arquitetura MVVM para a camada de apresentação.

- Design Patterns Creational -> Padrões para criação de instancias escondendo a lógica Builder, Factory. Repository: Padrão usado para abstrair o acesso a dados, fornecendo uma interface consistente para o ViewModel interagir com diferentes fontes de dados (banco de dados, API, etc.). Dependency Injection: Princípios de injeção de dependência podem ser observados na forma como as dependências são fornecidas aos componentes do aplicativo, promovendo a modularidade e a testabilidade.
- O Framework Jetpack Compose foi utilizado para montagem da UI programaticamente. UI Declarativa: Construindo interfaces de usuário com Jetpack Compose, definindo a interface do usuário como uma função do estado do aplicativo.
- Testes Unitários: JUnit, Mockk
- DI: Koin - Gestor de arquivos sendo utilizado como gestor de dependencias. pontos n positivos: Service locator, erros em tempo de execução, difícil de escalar por isso."
- Multithread/Programação Assíncrona:  - Coroutines para gerar assíncronas e simultâneas
- Gitflow - está em ambiente git, foi desenvolvido usando o Git para versionamento.
- Tecnologias:
    - LiveData: Componente do Jetpack que permite observar dados e atualizar a interface do usuário automaticamente quando os dados mudam.
    - ViewModel: Componente do Jetpack que armazena e gerencia dados relacionados à interface do usuário, sobrevivendo a mudanças de configuração.
    - Retrofit: Biblioteca popular para fazer solicitações de rede HTTP, usada para se comunicar com APIs REST.
 


      Autora... Marlena Martins
