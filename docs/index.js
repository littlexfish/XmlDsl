const EXAMPLE_1_LEFT = `<span class="code-element">ele</span>&nbsp;{
\t<span class="code-element">ele</span>&nbsp;{}
\t<span class="code-element">values</span>&nbsp;{
\t\t<span class="code-keyword">for</span>&nbsp;<span class="code-field">i</span>&nbsp;<span class="code-keyword">in</span>&nbsp;<span class="code-number">0</span>..<span class="code-number">10</span>&nbsp;{
\t\t\t<span class="code-element">value</span>&nbsp;{
\t\t\t\t<span class="code-field">i</span>
\t\t\t}
\t\t}
\t}
}`
const EXAMPLE_1_RIGHT = `<span class="code-element">&lt;ele&gt;</span>
\t<span class="code-element">&lt;ele&gt;</span>
\t<span class="code-element">&lt;/ele&gt;</span>
\t<span class="code-element">&lt;values&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t0
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t1
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t2
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t3
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t4
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t5
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t6
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t7
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t8
\t\t<span class="code-element">&lt;/value&gt;</span>
\t\t<span class="code-element">&lt;value&gt;</span>
\t\t\t9
\t\t<span class="code-element">&lt;/value&gt;</span>
\t<span class="code-element">&lt;/values&gt;</span>
<span class="code-element">&lt;/ele&gt;</span>`

function switch_example_1(type) {
    let pre = document.getElementById("example1")
    let tab_dsl = document.getElementById("example1_tab_dsl")
    let tab_xml = document.getElementById("example1_tab_xml")
    if(type === 'dsl') {
        pre.innerHTML = EXAMPLE_1_LEFT
        tab_dsl.classList.add("active")
        tab_xml.classList.remove("active")
    }
    else {
        pre.innerHTML = EXAMPLE_1_RIGHT
        tab_dsl.classList.remove("active")
        tab_xml.classList.add("active")
    }
}

const EXAMPLE_2_LEFT = `<span class="code-element">html</span>&nbsp;{
\t<span class="code-element">head</span>&nbsp;{
\t\t<span class="code-element">title</span>&nbsp;{
\t\t\t<span class="code-string">"Title"</span>
\t\t}
\t}
\t<span class="code-element">body</span>&nbsp;{
\t\t<span class="code-keyword">attr</span>&nbsp;<span class="code-field">style</span>&nbsp;=&nbsp;{&nbsp;<span class="code-string">'margin'</span>:&nbsp;<span class="code-string">'none'</span>,&nbsp;<span class="code-string">'background'</span>:&nbsp;<span class="code-string">'darkgray'</span>&nbsp;}
\t\t<span class="code-field">style</span>&nbsp;+=&nbsp;<span class="code-function">pairOf</span>(<span class="code-string">'color'</span>,&nbsp;<span class="code-string">'white'</span>)
\t\t<span class="code-element">h1&nbsp;</span>{
\t\t\t<span class="code-keyword">attr </span><span class="code-field">style</span>&nbsp;=&nbsp;<span class="code-string">'color:&nbsp;white'</span>
\t\t\t<span class="code-string">"Hello,&nbsp;World"</span>
\t\t}
\t\t<span class="code-string">"Hello,&nbsp;XmlDsl"</span>
\t}
}`

const EXAMPLE_2_RIGHT = `<span class="code-element">&lt;html&gt;</span>
\t<span class="code-element">&lt;head&gt;</span>
\t\t<span class="code-element">&lt;title&gt;</span>
\t\t\tTitle
\t\t<span class="code-element">&lt;/title&gt;</span>
\t<span class="code-element">&lt;/head&gt;</span>
\t<span class="code-element">&lt;body</span> <span class="code-field">style</span>=<span class="code-string">"margin:&nbsp;none;&nbsp;background:&nbsp;darkgray;&nbsp;color:&nbsp;white"</span><span class="code-element">&gt;</span>
\t\t<span class="code-element">&lt;h1</span> <span class="code-field">style</span>=<span class="code-string">"color:&nbsp;white"</span><span class="code-element">&gt;</span>
\t\t\tHello,&nbsp;World
\t\t<span class="code-element">&lt;/h1&gt;</span>
\t\tHello,&nbsp;XmlDsl
\t<span class="code-element">&lt;/body&gt;</span>
<span class="code-element">&lt;/html&gt;</span>`

function switch_example_2(type) {
    let pre = document.getElementById("example2")
    let tab_dsl = document.getElementById("example2_tab_dsl")
    let tab_html = document.getElementById("example2_tab_html")
    if(type === 'dsl') {
        pre.innerHTML = EXAMPLE_2_LEFT
        tab_dsl.classList.add("active")
        tab_html.classList.remove("active")
    }
    else {
        pre.innerHTML = EXAMPLE_2_RIGHT
        tab_dsl.classList.remove("active")
        tab_html.classList.add("active")
    }
}

switch_example_1('dsl')
switch_example_2('dsl')



