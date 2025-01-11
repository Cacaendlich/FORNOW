# FORNOW - Aplicativo de Delivery - Interface com Jetpack Compose

<h2>Descrição</h2>
<p>
Este projeto é uma interface de aplicativo de delivery desenvolvida utilizando
<strong>Jetpack Compose</strong>. O foco principal é a construção de uma
<em>UI</em> fluida, responsiva e com suporte a temas claro e escuro.
O projeto não aplica uma arquitetura de dados, como MVVM ou Clean Architecture,
estando exclusivamente voltado para o frontend.
</p>

<h2>Capturas de Tela</h2>


<h2>Principais Recursos</h2>
<ul>
<li>Alternância entre tema claro e escuro.</li>
<li>Barra de pesquisa funcional para filtrar produtos por nome.</li>
<li>Componentes estilizados, como:
<ul>
<li>Cabeçalho com gradiente e alternador de tema.</li>
<li>Cartões de produtos com imagens, nome e preço.</li>
</ul>
</li>
<li>Exibição de categorias de produtos organizadas em seções horizontais e verticais.</li>
</ul>

<h2>Principais Recursos</h2>
<ul>
<li>Alternância entre tema claro e escuro.</li>
<li>Barra de pesquisa funcional para filtrar produtos por nome.</li>
<li>Exibição de categorias de produtos organizadas em seções horizontais e verticais.</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
<li>Kotlin</li>
<li>Jetpack Compose</li>
<li>Material 3</li>
</ul>

<h2>Estrutura do Código</h2>
<p>
O código está organizado em funções <strong>@Composable</strong> que estruturam a interface. Alguns destaques:
</p>
<ul>
<li><code>MainActivity</code>: Configuração inicial do aplicativo, incluindo o tema e layout principal.</li>
<li><code>App</code>: Controla o estado do tema e define o layout geral.</li>
<li><code>MainLayout</code>: Exibe a barra de pesquisa, cabeçalho e lista de produtos organizada em seções.</li>
<li><code>ProductItemLayout</code>: Renderiza informações de um único produto em um cartão estilizado.</li>
</ul>

<h2>Pré-requisitos</h2>
<ul>
<li>Android Studio Arctic Fox ou mais recente.</li>
<li>SDK Android configurada para Compose.</li>
</ul>

<h2>Como Executar</h2>
<ol>
<li>Clone o repositório para sua máquina local.</li>
<li>Abra o projeto no Android Studio.</li>
<li>Compile e execute o aplicativo em um dispositivo físico ou emulador.</li>
</ol>

## Próxima Etapa: Refatoração e Novos Recursos

A próxima fase do projeto envolve a refatoração da estrutura atual para aplicar os princípios de **Clean Architecture**, **SOLID**, e um gerenciamento de estado robusto. 
Essas mudanças visam melhorar a manutenibilidade, escalabilidade e clareza do código, além de preparar o projeto para novos recursos.

- **Aplicação de Clean Architecture**: A estrutura do projeto será reorganizada para seguir os princípios da Clean Architecture, separando as responsabilidades em camadas, como a camada de apresentação, domínio e dados.
- **Princípios SOLID**: O código será refatorado para seguir os princípios SOLID, garantindo um design de software mais flexível e de fácil manutenção.
- **Gerenciamento de Estado**: Será implementado um gerenciamento de estado mais eficiente para o controle de UI e lógica de negócios, possibilitando uma experiência mais fluida e escalável.
- **Preferências de Tema**: Implementação de um sistema para salvar a preferência do usuário entre os temas claro e escuro, mantendo a escolha persistente entre as sessões do aplicativo.
- **Carrinho de Compras**: Será adicionado um carrinho de compras, permitindo ao usuário adicionar, visualizar e remover produtos. A funcionalidade incluirá o gerenciamento do estado do carrinho e a persistência dos itens.

Essas alterações proporcionarão uma base sólida para o crescimento do projeto, além de melhorar a qualidade do código e a experiência do usuário.