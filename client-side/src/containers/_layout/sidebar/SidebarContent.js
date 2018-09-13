import React, {Component} from 'react';
import SidebarLink from './SidebarLink';
import SidebarCategory from './SidebarCategory';

class SidebarContent extends Component {

  hideSidebar = () => {
    this.props.onClick();
  };

  render() {
    return (
      <div className='sidebar_content'>
        <ul className='sidebar_block'>
          <SidebarLink title='Log In' icon='exit' route='/log_in' onClick={this.hideSidebar}/>
          <SidebarCategory title='Layout' icon='layers'>
            <li className='sidebar_link' onClick={this.props.changeToLight}>
              <p className='sidebar_link-title'>Light Theme</p>
            </li>
            <li className='sidebar_link' onClick={this.props.changeToDark}>
              <p className='sidebar_link-title'>Dark Theme</p>
            </li>
          </SidebarCategory>
        </ul>
        <ul className='sidebar_block'>
          <SidebarCategory title='Example Pages' icon='diamond'>
            <SidebarLink title='Page one' route='/pages/one' onClick={this.hideSidebar}/>
            <SidebarLink title='Page two' route='/pages/two' onClick={this.hideSidebar}/>
          </SidebarCategory>
        </ul>
      </div>
    )
  }
}

export default SidebarContent;