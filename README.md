<h1 align="center">VUTTR - StartIdea Backend</h1>

Proposto pela empresa a criação de uma API com requisições ao banco de dados, onde a aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrições e tags.

<h3>Tecnologias utilizadas</h3>

<ul>
<li><a href="https://spring.io/projects/spring-boot">SpringBoot</a></li>
<li><a href="https://projectlombok.org/">Loombok</a></li>
<li><a href="https://www.mysql.com/">MySql</a></li>
<li><a href="https://maven.apache.org/">Apache/Maven</a></li>
<li><a href="https://aws.amazon.com/pt/">AWS</a></li>
</ul>

<h3>Como Utilizar?🤔</h3>

<h5>EndPoints</h5>

`GET /tools`

`GET /tools/id`

`DELETE /tools/id`

`POST /tools` - Pequena observação sobre este item, foi solicitado que as tags iriam ser passadas como um Array de string no corpo do JSON, porem optei pela forma de produção que seria utilizar uma segunda tabela onde existiram as tags. Acredito que desta forma seria mais facil manipular os dados.




