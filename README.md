# Votação de uma Assembléia.
<h1 align="center">
  
## Descrição do Projeto
<p align="left"> O sistema permite o cadastro de eleitores e candidatos, a criação de uma eleição com uma lista de candidatos, e o registro dos votos dos eleitores.

O sistema também apresenta algumas funcionalidades interessantes, como a verificação da autenticidade dos eleitores por meio de um código gerado no momento da votação e a possibilidade de definir um tempo limite para a votação.

Em resumo, o objetivo do projeto é fornecer uma solução simples e prática para a realização de eleições em assembleias ou reuniões virtuais, que pode ser adaptada e aprimorada de acordo com as necessidades de cada caso.</p>  
  
## Tecnologias Usadas
  - Java 11 : uma linguagem de programação orientada a objetos amplamente utilizada no desenvolvimento de aplicações.
  - Spring Boot :um framework que facilita o desenvolvimento de aplicativos em Java, fornecendo recursos para configuração automática, gerenciamento de dependências e criação de aplicativos web.
  - Maven : uma ferramenta de gerenciamento de projetos em Java que ajuda a automatizar a compilação, o teste e a implantação do aplicativo.

## Principias Classes do Sistema
   Essas classes representam os objetos principais que o sistema.
    
  - Associado: Ela representa um membro da organização que pode participar das votações.
  - Pauta : representa uma pauta de votação, com um título e uma descrição.
  - SessaoVotacao: representa uma sessão de votação para uma determinada pauta, com um tempo limite e um estado atual (aberto ou fechado).
  - Voto: representa um voto dado por um membro para uma determinada pauta, com a opção de voto (SIM ou NÃO) e informações sobre quem deu o voto.


