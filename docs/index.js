const COPY_RESTORE_TIME = 3000;

function switch_example(self, idx) {
    let tab = self.parentElement;
    let code = tab.parentElement.querySelector(".code-block");
    for(const t of tab.children) {
        t.classList.remove("active");
    }
    tab.children[idx].classList.add("active");
    for(const c of code.children) {
        c.classList.remove("active");
    }
    code.children[idx].classList.add("active");
    resetCopyAnimation(tab.parentElement.querySelector(".copy .copy-button"));
}

function copy(copyIcon) {
    let active = copyIcon.parentElement.parentElement.querySelector(".code-block .code.active");
    let content = active.textContent;
    navigator.clipboard.writeText(content).then(r => {
        let anim = runAnimation(copyIcon, 'Copy_Success.json');
        setTimeout(() => {
            anim.setDirection(-1);
            anim.play();
        }, COPY_RESTORE_TIME);
    }).catch(e => {
        let anim = runAnimation(copyIcon, 'Copy_Error.json');
        setTimeout(() => {
            anim.setDirection(-1);
            anim.play();
        }, COPY_RESTORE_TIME);
    });

}

function runAnimation(container, path) {
    let anim = lottie.loadAnimation({
        container: container,
        renderer: 'svg',
        loop: false,
        autoplay: true,
        path: path
    });
    container.innerHTML = '';
    return anim;
}

function resetCopyAnimation(container) {
    runAnimation(container, 'Copy(Static).json');
}

function main() {
    let allCopyIcon = document.querySelectorAll(".copy .copy-button");
    for(const copyIcon of allCopyIcon) {
        resetCopyAnimation(copyIcon);
        copyIcon.onclick = () => copy(copyIcon);
    }
}

main();
