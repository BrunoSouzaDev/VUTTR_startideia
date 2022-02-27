<h1 align="center">VUTTR - StartIdea Backend</h1>

Proposto pela empresa a criação de uma API com requisições ao banco de dados, onde a aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrições e tags.

<hr>

<h3>Tecnologias utilizadas :rocket: </h3>

<ul>
<li><a href="https://spring.io/projects/spring-boot">SpringBoot</a></li>
<li><a href="https://projectlombok.org/">Loombok</a></li>
<li><a href="https://www.mysql.com/">MySql</a></li>
<li><a href="https://maven.apache.org/">Apache/Maven</a></li>
<li><a href="https://aws.amazon.com/pt/">AWS</a></li>
<li><a href="https://swagger.io/">Swagger</a></li>
<li><a href="https://spring.io/projects/spring-data-jpa">Jpa</a></li>
<li><a href="https://www.heroku.com">Heroku</a></li>
</ul>

<hr>

<h3>Como Utilizar?🤔</h3>

Para iniciar o projeto é necessário clonar o repositório e importar para IDE(Eclipse, Intellij) de preferência.

<ul>
<li><a href="https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html">Java SDK</a></li>
<li><a href="https://www.mysql.com/">MySql</a></li>
</ul>

Ou voce pode testar ela na nuvem (heroku) <a href="https://vuttr-startideia-api.herokuapp.com/swagger-ui.html#/tool45controller">aqui</a>

<h5>EndPoints</h5>

`GET /tools`

`GET /tools?tag=node` - pode substituir a tag

`GET /tools/id`

`DELETE /tools/id`

`POST /tools` - Pequena observação sobre este item, foi solicitado que as tags iriam ser passadas como um Array de string no corpo do JSON, porem optei pela forma de produção que seria utilizar uma segunda tabela onde existiram as tags em forma de objeto. Acredito que desta forma seria mais fácil manipular os dados.

```
{
    "title": "fastify",
    "link": "https://www.fastify.io/",
    "dsTool": "Extremely fast and simple, low-overhead web framework for NodeJS. Supports HTTP2.",
    "tags":[{"name":"web"}, {"name":"http2"}, {"name":"framework"},{"name":"node"},{"name":"localhost"},{"name":"https"}]
}
```

Formato que deve ser passado no endpoint de POST




