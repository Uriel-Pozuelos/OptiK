class iconPerson extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-person-fill">
    <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
  </svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-person', iconPerson);

class iconLock extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" fill="currentColor"><path d="M15.8 8H14V5.6C14 2.703 12.665 1 10 1 7.334 1 6 2.703 6 5.6V8H4c-.553 0-1 .646-1 1.199V17c0 .549.428 1.139.951 1.307l1.197.387A7.731 7.731 0 0 0 7.1 19h5.8a7.68 7.68 0 0 0 1.951-.307l1.196-.387c.524-.167.953-.757.953-1.306V9.199C17 8.646 16.352 8 15.8 8zM12 8H8V5.199C8 3.754 8.797 3 10 3s2 .754 2 2.199V8z"/></svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
  }
    </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-lock', iconLock);

class iconHome extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
        <svg width="20px" height="20px" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" fill="currentColor"><path d="M18.672 11H17v6c0 .445-.194 1-1 1h-4v-6H8v6H4c-.806 0-1-.555-1-1v-6H1.328c-.598 0-.47-.324-.06-.748L9.292 2.22c.195-.202.451-.302.708-.312.257.01.513.109.708.312l8.023 8.031c.411.425.539.749-.059.749z"/></svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
  }
    </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-home', iconHome);

class iconEye extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-eye"><path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path><circle cx="12" cy="12" r="3"></circle></svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
  }
    </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-eye', iconEye);

class iconUpdate extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill="currentColor">
    <path fill="none" stroke="currentColor" stroke-width="2" d="M1.7507,16.0022 C3.3517,20.0982 7.3367,23.0002 11.9997,23.0002 C18.0747,23.0002 22.9997,18.0752 22.9997,12.0002 M22.2497,7.9982 C20.6487,3.9012 16.6627,1.0002 11.9997,1.0002 C5.9247,1.0002 0.9997,5.9252 0.9997,12.0002 M8.9997,16.0002 L0.9997,16.0002 L0.9997,24.0002 M22.9997,0.0002 L22.9997,8.0002 L14.9997,8.0002"/>
  </svg>
  
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
  }
    </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-update', iconUpdate);

class iconDelete extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 32 32" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><defs><style>.cls-1{fill:none;}</style></defs><title>trash-can</title><rect x="12" y="12" width="2" height="12"/><rect x="18" y="12" width="2" height="12"/><path d="M4,6V8H6V28a2,2,0,0,0,2,2H24a2,2,0,0,0,2-2V8h2V6ZM8,28V8H24V28Z"/><rect x="12" y="2" width="8" height="2"/><rect id="_Transparent_Rectangle_" data-name="&lt;Transparent Rectangle&gt;" class="cls-1" width="32" height="32"/></svg>

    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
  }
    </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-delete', iconDelete);

class iconCheck extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
    
    <svg width="20px" height="20px" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" fill="currentColor"><path d="M8.294 16.998c-.435 0-.847-.203-1.111-.553L3.61 11.724a1.392 1.392 0 0 1 .27-1.951 1.392 1.392 0 0 1 1.953.27l2.351 3.104 5.911-9.492a1.396 1.396 0 0 1 1.921-.445c.653.406.854 1.266.446 1.92L9.478 16.34a1.39 1.39 0 0 1-1.12.656c-.022.002-.042.002-.064.002z"/></svg>
    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
  }
    </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-check', iconCheck);

class iconClean extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
      
    <svg width="20px" height="20px" viewBox="0 0 32 32" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <defs>
    <style>
      .cls-1 {
        fill: none;
      }
    </style>
  </defs>
  <title>clean</title>
  <rect x="20" y="18" width="6" height="2" transform="translate(46 38) rotate(-180)"/>
  <rect x="24" y="26" width="6" height="2" transform="translate(54 54) rotate(-180)"/>
  <rect x="22" y="22" width="6" height="2" transform="translate(50 46) rotate(-180)"/>
  <path d="M17.0029,20a4.8952,4.8952,0,0,0-2.4044-4.1729L22,3,20.2691,2,12.6933,15.126A5.6988,5.6988,0,0,0,7.45,16.6289C3.7064,20.24,3.9963,28.6821,4.01,29.04a1,1,0,0,0,1,.96H20.0012a1,1,0,0,0,.6-1.8C17.0615,25.5439,17.0029,20.0537,17.0029,20ZM11.93,16.9971A3.11,3.11,0,0,1,15.0041,20c0,.0381.0019.208.0168.4688L9.1215,17.8452A3.8,3.8,0,0,1,11.93,16.9971ZM15.4494,28A5.2,5.2,0,0,1,14,25H12a6.4993,6.4993,0,0,0,.9684,3H10.7451A16.6166,16.6166,0,0,1,10,24H8a17.3424,17.3424,0,0,0,.6652,4H6c.031-1.8364.29-5.8921,1.8027-8.5527l7.533,3.35A13.0253,13.0253,0,0,0,17.5968,28Z"/>
  <rect id="_Transparent_Rectangle_" data-name="&lt;Transparent Rectangle&gt;" class="cls-1" width="32" height="32"/>
</svg>

    
      ${this.getStyles()}
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
    * {
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
  }
    </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-clean', iconClean);

class iconSave extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
    <svg width="20px" height="20px" viewBox="-32 0 512 512" xmlns="http://www.w3.org/2000/svg" fill="currentColor"><path d="M433.941 129.941l-83.882-83.882A48 48 0 0 0 316.118 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h352c26.51 0 48-21.49 48-48V163.882a48 48 0 0 0-14.059-33.941zM224 416c-35.346 0-64-28.654-64-64 0-35.346 28.654-64 64-64s64 28.654 64 64c0 35.346-28.654 64-64 64zm96-304.52V212c0 6.627-5.373 12-12 12H76c-6.627 0-12-5.373-12-12V108c0-6.627 5.373-12 12-12h228.52c3.183 0 6.235 1.264 8.485 3.515l3.48 3.48A11.996 11.996 0 0 1 320 111.48z"/></svg>
    `;
		return template;
	}

	getStyles() {
		return `
    <style>
      * {
        padding: 0%;
        margin: 0%;
        box-sizing: border-box;
      }
    </style>
  `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-save', iconSave);

class iconSearch extends HTMLElement {
	constructor() {
		super();
		this.attachShadow({ mode: 'open' });
	}

	getTemplate() {
		const template = document.createElement('template');
		template.innerHTML = `
    <svg width="20px" height="20px" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg" fill="currentColor"><path d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"/></svg>
    `;
		return template;
	}

	getStyles() {
		return `
      <style>
        * {
          padding: 0%;
          margin: 0%;
          box-sizing: border-box;
        }
      </style>
    `;
	}

	render() {
		this.shadowRoot.appendChild(
			this.getTemplate().content.cloneNode(true)
		);
	}

	connectedCallback() {
		this.render();
	}
}

customElements.define('icon-search', iconSearch);
